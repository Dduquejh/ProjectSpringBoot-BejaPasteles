# **Proyecto de Gestión de Clientes, Productos y Órdenes**

Este proyecto es una aplicación backend desarrollada en Spring Boot que permite gestionar entidades de **Cliente**, **Producto**, y **Orden**. La aplicación ofrece funcionalidades de CRUD (Crear, Leer, Actualizar y Eliminar) para los Clientes y Productos, y la capacidad de crear y leer Órdenes que vinculan a un Producto con un Cliente.

## **Características**

### 1. **Cliente**
- Crear, Leer, Actualizar y Eliminar clientes.
- Validación de los datos ingresados usando Jakarta Validations.

### 2. **Producto**
- Crear, Leer, Actualizar y Eliminar productos.
- Validación de los datos de productos, incluyendo restricciones de stock disponible usando Jakarta Validations.

### 3. **Orden**
- Crear y Leer órdenes que vinculan un cliente con un producto.
- Validación de la existencia de los IDs de Cliente y Producto antes de crear una orden.
- Verificación de que la cantidad solicitada en la orden no supere el stock disponible del producto.

## **Validaciones**

Se implementaron restricciones en las columnas de las tablas utilizando **Jakarta Validations** para garantizar la integridad de los datos. Sin embargo, actualmente hay un problema con la ejecución de estas validaciones, lo que impide que se realicen las comprobaciones necesarias durante las operaciones POST y UPDATE, y, por lo tanto, no se maneja adecuadamente los errores.

## **Tecnologías Utilizadas**
- **Spring Boot**: Framework principal del proyecto.
- **Jakarta Validations**: Para la validación de datos.
- **PostgreSQL**: Base de datos (configurable según el entorno).
- **Swagger**: Documentación y pruebas de API.
