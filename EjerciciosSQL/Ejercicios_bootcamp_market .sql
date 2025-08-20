--Crear una base de datos que se llame bootcamp_market y restaurar la base de datos con el backup del drive.
--Consultas a realizar:
--1.	 Top clientes con más facturas

select nombre, apellido, COUNT(*) AS cantidad from cliente
join factura on cliente.id = cliente_id
group by nombre, apellido
order by cantidad desc


--2.	Top clientes que más gastaron

SELECT 
	cliente.nombre, 
	cliente.apellido, 
	SUM(producto.precio * factura_detalle.cantidad) as total
FROM cliente
JOIN factura ON cliente.id = factura.cliente_id
JOIN factura_detalle ON factura.id = factura_detalle.factura_id
JOIN producto ON factura_detalle.producto_id = producto.id
GROUP BY cliente.nombre, cliente.apellido
ORDER BY total desc
limit 10;

--3.	Top monedas más utilizadas

select moneda.nombre, COUNT(*) AS cantidad from factura
join moneda on factura.moneda_id = moneda.id
group by moneda.nombre
order by cantidad desc


--4.	Top proveedor de productos

select proveedor.nombre, count(*) as cantidad from producto
join proveedor on producto.proveedor_id = proveedor.id
group by proveedor.nombre
order by cantidad desc

--5.	Productos más vendidos

select 
	producto.nombre,
	SUM(factura_detalle.cantidad) as cantidad
from factura_detalle
join producto on producto_id = producto.id
group by producto.nombre
order by cantidad desc
limit 10

--6.	Productos menos vendidos

select 
	producto.nombre,
	SUM(factura_detalle.cantidad) as cantidad
from factura_detalle
join producto on producto_id = producto.id
group by producto.nombre
order by cantidad asc
limit 10


--7.	Consulta que muestre fecha de emisión de factura, nombre y apellido del cliente, 
--	nombres de productos de esa factura, cantidades compradas, nombre de tipo de factura 
--	de una factura específica

select 
	factura.fecha_emision, 
	cliente.nombre, 
	cliente.apellido, 
	producto.nombre, 
	factura_detalle.cantidad, 
	factura_tipo.nombre 
from factura_detalle
join factura on factura_id = factura.id
join cliente on cliente_id = cliente.id
join factura_tipo on factura_tipo_id = factura_tipo.id
join producto on producto_id = producto.id
-- factura específica:
where factura.id = 13


--8.	Montos de facturas ordenadas según totales

select 
	factura.id, 
	SUM(producto.precio * factura_detalle.cantidad) as total
from factura_detalle
join factura on factura_id = factura.id
join cliente on cliente_id = cliente.id
join factura_tipo on factura_tipo_id = factura_tipo.id
join producto on producto_id = producto.id
group by factura.id
order by total desc
limit 10


--9.	Mostrar el iva 10% de los montos totales de facturas (suponer que todos los productos tienen IVA 10%)

select 
	factura.id, 
	SUM(producto.precio * factura_detalle.cantidad) as total,
	Round(SUM(producto.precio * factura_detalle.cantidad) * 0.10) as "IVA 10%" 
--	SUM(producto.precio * factura_detalle.cantidad) * 0.10 as "IVA 10%"
from factura_detalle
join factura on factura_id = factura.id
join cliente on cliente_id = cliente.id
join factura_tipo on factura_tipo_id = factura_tipo.id
join producto on producto_id = producto.id
group by factura.id
order by total desc

