from fastapi import APIRouter, Depends
from sqlmodel import Session
from app.database import get_session
from .schemas import ClienteCreate, ClienteRead
from . import service

router = APIRouter(prefix="/clientes", tags=["Clientes"])


@router.get("/", response_model=list[ClienteRead])
def listar(
    nombre: str = None,
    session: Session = Depends(get_session),
):
    return service.listar_clientes(session, nombre)


@router.get("/{cliente_id}", response_model=ClienteRead)
def obtener(
    cliente_id: int,
    session: Session = Depends(get_session),
):
    return service.obtener_cliente(session, cliente_id)


@router.post("/", response_model=ClienteRead)
def crear(
    cliente: ClienteCreate,
    session: Session = Depends(get_session),
):
    return service.crear_cliente(session, cliente)


@router.delete("/{cliente_id}")
def eliminar(
    cliente_id: int,
    session: Session = Depends(get_session),
):
    return service.eliminar_cliente(session, cliente_id)