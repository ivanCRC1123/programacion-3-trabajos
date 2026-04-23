from fastapi import HTTPException
from sqlmodel import Session
from . import repository
from .model import Cliente


def listar_clientes(session: Session, nombre: str = None):
    clientes = repository.get_all(session)

    if nombre:
        return [c for c in clientes if nombre.lower() in c.nombre.lower()]

    return clientes


def obtener_cliente(session: Session, cliente_id: int):
    cliente = repository.get_by_id(session, cliente_id)

    if not cliente:
        raise HTTPException(status_code=404, detail="Cliente no encontrado")

    return cliente


def crear_cliente(session: Session, cliente: Cliente):
    if cliente.edad < 18:
        raise HTTPException(status_code=400, detail="El cliente debe ser mayor de edad")

    return repository.create(session, cliente)


def eliminar_cliente(session: Session, cliente_id: int):
    cliente = repository.get_by_id(session, cliente_id)

    if not cliente:
        raise HTTPException(status_code=404, detail="Cliente no encontrado")

    repository.delete(session, cliente)
    return {"mensaje": "Cliente eliminado"}