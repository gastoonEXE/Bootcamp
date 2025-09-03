import React, { useState } from "react"; // Importa React y el hook useState

// Define el tipo de datos para cada elemento principal y sus subelementos
type DatosElemento = {
  elemento: string;
  subElementos: string[];
};

// Define las props que recibe el componente: un array de DatosElemento
type Props = {
  datos: DatosElemento[];
};

// Componente funcional ListaExpandible
const ListaExpandible: React.FC<Props> = ({ datos }) => {
  // Estado para controlar qué elementos están expandidos
  const [expandido, setExpandido] = useState<Record<string, boolean>>({});
  // Estado para controlar el elemento o subelemento seleccionado
  const [seleccionado, setSeleccionado] = useState<string | null>(null);

  // Función para expandir/colapsar un elemento o seleccionar si no tiene subelementos
  const alternarExpandido = (elemento: string, tieneSubElementos: boolean) => {
    if (tieneSubElementos) {
      // Si tiene subelementos, alterna el estado expandido
      setExpandido((prev) => ({ ...prev, [elemento]: !prev[elemento] }));
    } else {
      // Si no tiene subelementos, lo selecciona
      setSeleccionado(elemento);
    }
  };

  // Función para seleccionar un subelemento
  const manejarSubClick = (subElemento: string) => {
    setSeleccionado(subElemento);
  };

  //muestra la flecha desplegada
  // const desplegado = subElementos.length > 0 && ();

  // Renderiza la lista expandible
  return (
    <div>
      {datos.map(({ elemento, subElementos }) => (
        <div key={elemento}>
          {/* Elemento principal, se puede expandir si tiene subelementos */}
          <div
            onClick={() => alternarExpandido(elemento, subElementos.length > 0)}
            style={{
              backgroundColor:
                seleccionado === elemento ? "#fdababff" : "white", // Color si está seleccionado
              color: "black",
              padding: "10px",
              margin: "5px",
              marginRight: "15px",
              borderColor: "black",
              border:
                seleccionado === elemento ? "3px solid red" : "3px solid black", // Color si está seleccionado
              // border: "3px solid black",
              // text-align-last: justify;
              textAlignLast: "justify",
              cursor: "pointer",
            }}
          >
            {elemento}
            {/* Muestra una flecha si el elemento tiene subelementos */}
            {subElementos.length > 0 && (
              <span style={{ marginRight: "5px", fontSize: "18px" }}>
                {expandido[elemento] ? "\u25BC" : "\u25B6"}
              </span>
            )}
          </div>

          {/* Si el elemento está expandido, muestra sus subelementos */}
          {expandido[elemento] &&
            subElementos.map((sub) => (
              <div
                key={sub}
                onClick={() => manejarSubClick(sub)}
                style={{
                  backgroundColor: seleccionado === sub ? "#fdababff" : "white", // Color si está seleccionado
                  color: "black",
                  padding: "8px 20px",
                  border:
                    seleccionado === sub ? "3px solid red" : "3px solid blue", // Color si está seleccionado
                  margin: "2px 5px",
                  marginLeft: "15px",
                  cursor: "pointer",
                }}
              >
                {sub}
              </div>
            ))}
        </div>
      ))}
    </div>
  );
};

export default ListaExpandible; // Exporta el componente para usarlo
