import os

def create_directories(base_path):
    directories = [
        "docker",
        "scripts",
        "data/postgres",
        "config"
    ]

    for directory in directories:
        path = os.path.join(base_path, directory)
        os.makedirs(path, exist_ok=True)
        print(f"Directorio creado: {path}")

if __name__ == "__main__":
    base_path = os.path.abspath("./")
    create_directories(base_path)
    print("Estructura de directorios creada exitosamente.")
