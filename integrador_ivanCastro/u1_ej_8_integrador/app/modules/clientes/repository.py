from sqlmodel import select
from .model import Cliente

def get_all(session):
    return session.exec(select(Cliente)).all()

def get_by_id(session, cliente_id):
    return session.get(Cliente, cliente_id)

def create(session, cliente):
    session.add(cliente)
    session.commit()
    session.refresh(cliente)
    return cliente

def delete(session, cliente):
    session.delete(cliente)
    session.commit()