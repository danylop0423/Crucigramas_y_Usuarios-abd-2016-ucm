xquery version "3.0";
for $type in distinct-values(doc("/db/Abedemon.xml")//especie/tipo)
 return $type
