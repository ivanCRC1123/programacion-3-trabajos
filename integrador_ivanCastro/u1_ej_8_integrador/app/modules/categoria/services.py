from fastapi import HTTPException
from sqlmodel import Session
from . import repository
from .model import Categoria
from .schemas import CategoriaCreate


def crear(session: Session, data: CategoriaCreate):
    categoria = Categoria(**data.model_dump())
    return repository.create(session, categoria)


def obtener_todas(session: Session, skip: int = 0, limit: int = 10):
    return repository.get_all(session, skip, limit)


def obtener_por_id(session: Session, id: int):
    categoria = repository.get_by_id(session, id)

    if not categoria:
        raise HTTPException(status_code=404, detail="Categoría no encontrada")

    return categoria


def actualizar_total(session: Session, id: int, data: CategoriaCreate):
    categoria = repository.get_by_id(session, id)

    if not categoria:
        raise HTTPException(status_code=404, detail="Categoría no encontrada")

    for key, value in data.model_dump().items():
        setattr(categoria, key, value)

    return repository.update(session, categoria)


def desactivar(session: Session, id: int):
    categoria = repository.get_by_id(session, id)

    if not categoria:
        raise HTTPException(status_code=404, detail="Categoría no encontrada")

    categoria.activo = False
    return repository.update(session, categoria)