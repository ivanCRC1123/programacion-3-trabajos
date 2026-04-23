from sqlmodel import select
from u1_ej_8_integrador.app.modules.categoria.schemas import Categoria

def get_all(session, skip, limit):
    return session.exec(select(Categoria).offset(skip).limit(limit)).all()

def get_by_id(session, id):
    return session.get(Categoria, id)

def create(session, categoria):
    session.add(categoria)
    session.commit()
    session.refresh(categoria)
    return categoria

def update(session, categoria):
    session.add(categoria)
    session.commit()
    session.refresh(categoria)
    return categoria