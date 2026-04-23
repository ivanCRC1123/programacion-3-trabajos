from fastapi import APIRouter, Depends, Path, Query, status
from sqlmodel import Session
from typing import List
from app.database import get_session
from . import schemas, services

router = APIRouter(prefix="/productos", tags=["Productos"])


# ---------------------------------------------------------
# ALTA DE PRODUCTO
# ---------------------------------------------------------
@router.post(
    "/", response_model=schemas.ProductoRead, status_code=status.HTTP_201_CREATED
)
def alta_producto(
    producto: schemas.ProductoCreate,
    session: Session = Depends(get_session),
):
    return services.crear(session, producto)


# ---------------------------------------------------------
# LISTAR PRODUCTOS
# ---------------------------------------------------------
@router.get(
    "/", response_model=List[schemas.ProductoRead], status_code=status.HTTP_200_OK
)
def listar_productos(
    skip: int = Query(0, ge=0),
    limit: int = Query(10, le=50),
    session: Session = Depends(get_session),
):
    return services.obtener_todos(session, skip, limit)


# ---------------------------------------------------------
# DETALLE DE PRODUCTO
# ---------------------------------------------------------
@router.get(
    "/{id}", response_model=schemas.ProductoRead, status_code=status.HTTP_200_OK
)
def detalle_producto(
    id: int = Path(..., gt=0),
    session: Session = Depends(get_session),
):
    return services.obtener_por_id(session, id)


# ---------------------------------------------------------
# ACTUALIZACIÓN TOTAL
# ---------------------------------------------------------
@router.put(
    "/{id}", response_model=schemas.ProductoRead, status_code=status.HTTP_200_OK
)
def actualizar_producto(
    producto: schemas.ProductoCreate,
    id: int = Path(..., gt=0),
    session: Session = Depends(get_session),
):
    return services.actualizar_total(session, id, producto)


# ---------------------------------------------------------
# BORRADO LÓGICO
# ---------------------------------------------------------
@router.put(
    "/{id}/desactivar",
    response_model=schemas.ProductoRead,
    status_code=status.HTTP_200_OK,
)
def borrado_logico(
    id: int = Path(..., gt=0),
    session: Session = Depends(get_session),
):
    return services.desactivar(session, id)


# ---------------------------------------------------------
# CONSULTAR STOCK
# ---------------------------------------------------------
@router.get(
    "/{id}/stock",
    response_model=schemas.ProductoStockResponse,
    status_code=status.HTTP_200_OK,
)
def consultar_stock(
    id: int = Path(..., gt=0),
    session: Session = Depends(get_session),
):
    return services.obtener_estado_stock(session, id)