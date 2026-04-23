from fastapi import APIRouter, Depends, Path, Query, status
from sqlmodel import Session
from typing import List
from app.database import get_session
from . import schemas, services

router = APIRouter(prefix="/categorias", tags=["Categorías"])


@router.post(
    "/", response_model=schemas.CategoriaRead, status_code=status.HTTP_201_CREATED
)
def alta_categoria(
    categoria: schemas.CategoriaCreate,
    session: Session = Depends(get_session),
):
    return services.crear(session, categoria)


@router.get(
    "/", response_model=List[schemas.CategoriaRead], status_code=status.HTTP_200_OK
)
def listar_categorias(
    skip: int = Query(0, ge=0),
    limit: int = Query(10, le=50),
    session: Session = Depends(get_session),
):
    return services.obtener_todas(session, skip, limit)


@router.get(
    "/{id}", response_model=schemas.CategoriaRead, status_code=status.HTTP_200_OK
)
def detalle_categoria(
    id: int = Path(..., gt=0),
    session: Session = Depends(get_session),
):
    return services.obtener_por_id(session, id)


@router.put(
    "/{id}", response_model=schemas.CategoriaRead, status_code=status.HTTP_200_OK
)
def actualizar_categoria(
    categoria: schemas.CategoriaCreate,
    id: int = Path(..., gt=0),
    session: Session = Depends(get_session),
):
    return services.actualizar_total(session, id, categoria)


@router.put(
    "/{id}/desactivar",
    response_model=schemas.CategoriaRead,
    status_code=status.HTTP_200_OK,
)
def borrado_logico(
    id: int = Path(..., gt=0),
    session: Session = Depends(get_session),
):
    return services.desactivar(session, id)