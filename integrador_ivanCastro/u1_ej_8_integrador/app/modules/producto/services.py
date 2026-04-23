from fastapi import HTTPException
from sqlmodel import Session
from . import repository
from .model import Producto
from .schemas import ProductoCreate


def crear(session: Session, data: ProductoCreate):
    if data.precio <= 0:
        raise HTTPException(status_code=400, detail="Precio inválido")

    producto = Producto(**data.model_dump())
    return repository.create(session, producto)


def obtener_todos(session: Session, skip: int, limit: int):
    return repository.get_all(session, skip, limit)


def obtener_por_id(session: Session, id: int):
    producto = repository.get_by_id(session, id)

    if not producto:
        raise HTTPException(status_code=404, detail="Producto no encontrado")

    return producto


def actualizar_total(session: Session, id: int, data: ProductoCreate):
    producto = repository.get_by_id(session, id)

    if not producto:
        raise HTTPException(status_code=404, detail="Producto no encontrado")

    for key, value in data.model_dump().items():
        setattr(producto, key, value)

    return repository.update(session, producto)


def desactivar(session: Session, id: int):
    producto = repository.get_by_id(session, id)

    if not producto:
        raise HTTPException(status_code=404, detail="Producto no encontrado")

    producto.activo = False
    return repository.update(session, producto)


def obtener_estado_stock(session: Session, id: int):
    producto = repository.get_by_id(session, id)

    if not producto:
        raise HTTPException(status_code=404, detail="Producto no encontrado")

    alerta_stock = producto.stock < producto.stock_minimo

    return {
        "stock": producto.stock,
        "bajo_stock_minimo": alerta_stock,
        "activo": producto.activo,
    }