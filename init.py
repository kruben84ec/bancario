import os

def create_directories(base_path):
    directories = [
        "src/main/java/com/bancario/controller",
        "src/main/java/com/bancario/service",
        "src/main/java/com/bancario/repository",
        "src/main/java/com/bancario/model",
        "src/main/java/com/bancario/config",
        "src/main/resources/db/migration",
        "src/main/resources/static",
        "src/test",
        "docker",
        "scripts",
        "data/postgres",
        "config",
        ".github"
    ]

    for directory in directories:
        path = os.path.join(base_path, directory)
        os.makedirs(path, exist_ok=True)
        print(f"Directorio creado: {path}")

if __name__ == "__main__":
    base_path = os.path.abspath("bancario")
    create_directories(base_path)
    print("Estructura de directorios creada exitosamente.")
