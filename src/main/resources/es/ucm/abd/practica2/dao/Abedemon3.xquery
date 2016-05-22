xquery version "3.0";

declare variable $id as xs:string external;


for $especie in doc("Abedemon.xml")/bd-abedemon//especie[@id = $id]
return
    <html>
        <head></head>
        <body>
            <h1> { $especie/nombre } </h1>
            <img src="{ $especie/url }"/>
            <p>{ $especie/descripcion }</p>
            <p><b>Tipos: </b> { string-join($especie/tipo, ", ") (: !! Separados por comas :)}</p>
            <p>
                <b>Ataques: </b>
                {
                    let $id_ataque := data($especie/ataques/tiene-ataque/@id)
                    let $ataque := doc("Abedemon.xml")/bd-abedemon/ataque[@id = $id_ataque]
                    return string-join($ataque/nombre, ", ") (: Mostrar nombre de los ataques, añadir nueva consulta :)

                }
            </p>
            <p><b>Evoluciones: </b>
                <ul>
                    {
                        for $evolucion in $especie/evoluciones/especie
                        return <li><a href="{ $evolucion/@id }">{ data($evolucion/nombre) }</a></li>
                    }
                </ul>
            </p>
        </body>
    </html>
