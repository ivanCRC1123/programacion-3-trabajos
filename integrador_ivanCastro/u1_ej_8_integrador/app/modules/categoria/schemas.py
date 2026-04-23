from sqlmodel import SQLModel, Field

class Categoria(SQLModel, table=True):
    id: int | None = Field(default=None, primary_key=True)
    codigo: str
    descripcion: str
    activo: bool = True