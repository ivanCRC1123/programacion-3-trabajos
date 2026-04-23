from fastapi import FastAPI
from app.database import init_db

from app.modules.producto.routers import router as producto_router
from app.modules.categoria.routers import router as categoria_router
from app.modules.clientes.routers import router as clientes_router


def create_app() -> FastAPI:
    app = FastAPI(
        title="API Integradora - Unidad 1",
        description="Conceptos: Path, Query, Body, Pydantic, Errores.",
        version="1.0.0"
    )

    # 👉 Crear tablas al iniciar
    @app.on_event("startup")
    def on_startup():
        init_db()

    app.include_router(producto_router)
    app.include_router(categoria_router)
    app.include_router(clientes_router)

    return app


app = create_app()
