from sqlmodel import select
from .model import Producto

def get_all(session, skip, limit):
    return session.exec(select(Producto).offset(skip).limit(limit)).all()

def get_by_id(session, id):
    return session.get(Producto, id)

def create(session, producto):
    session.add(producto)
    session.commit()
    session.refresh(producto)
    return producto

def update(session, producto):
    session.add(producto)
    session.commit()
    session.refresh(producto)
    return producto