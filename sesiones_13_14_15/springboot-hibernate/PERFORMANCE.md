
# Rendimiento

1. pgtune: https://pgtune.leopard.in.ua/#/ la configuración está en el archivo postgresql.conf 

2. work_mem permite optimizar las consultas con ORDER BY

3. `EXPLAIN ANALYZE` en las consultas para saber cómo se están ejecutando.

4. Ver configuración: 
  * SHOW work_mem;
  * SHOW ALL;

5. Índices: estructura de datos separada a las tablas y que permite optimizar la recuperación de datos.
    * una columna
    * varias columnas
    * único
    * parcial (WHERE)
    * implícito (se crea automáticamente sobre la primary key)

Tipos de índices: 
* B-tree
* Hash
* GiST 
* SP-GiST
* GIN
* BRIN

CREATE INDEX idx_name ON table_name(col1);

* Permiten optimizar las consultas 
* Tienen el coste adicional de que cada vez que se insertan datos se tendrán que realizar más operaciones de escritura para mantener el índice actualizado. 

6. Particionamiento de tablas:
   * Por rango 
   * Por lista
   * Por hash

7. Vacuum 

A medida que se van realizando operaciones de escritura van quedando huecos:
Live rows 
Dead rows - filas cuyos datos han sido marcados para ser sobrescritos

VACUUM ANALYZE employee;

8. Hibernate:
 * Utilizar DTOs para las consultas.


Otros conceptos: 
CTE
Funciones ventana
Vistas y vistas materializadas
CTE (Common Table Expressions): son expresiones que permiten definir una consulta dentro de otra consulta en PostgreSQL. Se utilizan para simplificar consultas complejas y para dividir una consulta en partes más manejables y legibles. Las CTE se definen utilizando la cláusula WITH y se pueden utilizar en consultas SELECT, INSERT, UPDATE y DELETE.

Funciones ventana: son funciones analíticas que operan en un conjunto de filas seleccionadas por la consulta. Estas funciones calculan valores para cada fila en función de una ventana de filas que se especifica utilizando la cláusula OVER. Las funciones ventana se utilizan comúnmente para calcular totales acumulados, promedios móviles y clasificaciones, entre otras cosas.

Vistas: son consultas guardadas como objetos de la base de datos. Una vista es una tabla virtual que se puede consultar como cualquier otra tabla, pero que no tiene datos almacenados físicamente en ella. Las vistas se utilizan para simplificar y reutilizar consultas complejas, y para ocultar detalles de la estructura de la base de datos a los usuarios.

Vistas materializadas: son vistas que almacenan los resultados de la consulta en una tabla física en la base de datos. La vista materializada se actualiza en momentos específicos o cuando se realizan ciertas operaciones en la base de datos. Las vistas materializadas se utilizan para mejorar el rendimiento de consultas complejas y para reducir el tiempo necesario para realizar operaciones de lectura en grandes conjuntos de datos.