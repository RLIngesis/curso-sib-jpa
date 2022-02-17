create table pais (id_pais number, nombre varchar, primary key (id_pais));
create table departamento (id_departamento number, nombre varchar, id_pais number, primary key (id_departamento), foreign key (id_pais) references pais(id_pais));
create table municipio (id_municipio number, nombre varchar, id_departamento number, primary key (id_municipio), foreign key (id_departamento) references departamento(id_departamento));

create table cliente (id_cliente number, nombre varchar, direccion varchar, nit varchar, telefono varchar, email varchar, id_municipio number, primary key (id_cliente),  foreign key (id_municipio) references municipio(id_municipio));
create table sucursal (id_sucursal number, nombre varchar, direccion varchar, primary key (id_sucursal));
create table vendedor ( id_vendedor number, nombre varchar, puesto varchar, primary key (id_vendedor) );
create table sucursal_vendedor ( id_sucursal number, id_vendedor number, primary key (id_sucursal, id_vendedor), foreign key (id_sucursal) references sucursal(id_sucursal), foreign key (id_vendedor) references vendedor(id_vendedor) );
create table categoria ( id_categoria number, nombre varchar, descripcion varchar,  primary key (id_categoria) );
create table producto ( id_producto number,	id_categoria number, codigo_producto varchar, descripcion varchar, unidad_medida varchar, presentacion number, precio_unitario number(15,2), unidad_presentacion varchar, primary key (id_producto,id_categoria), foreign key (id_categoria) references categoria(id_categoria) );
create table inventario ( id_inventario number, id_producto number, id_categoria number, cantidad number,  precio number(15,2), primary key (id_inventario,id_producto,id_categoria), foreign key (id_producto,id_categoria) references producto(id_producto,id_categoria) );
create table factura ( id_factura number, id_cliente number, id_vendedor number, fecha date, monto_total number(15,2), numero_factura number, serie varchar, primary key (id_factura), foreign key (id_cliente) references cliente(id_cliente),	foreign key (id_vendedor) references vendedor(id_vendedor) );
create table detalle_factura (id_detalle_factura number, id_factura number, id_producto number,	id_categoria number, no_fila number, precio_unitario number(15,2),	cantidad number, primary key (id_detalle_factura),	foreign key (id_producto,id_categoria) references producto(id_producto,id_categoria) ,	foreign key (id_factura) references factura(id_factura));
create table cfg_secuencia (cod_secuencia varchar, correlativo number, primary key (cod_secuencia));