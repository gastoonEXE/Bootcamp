import ListaExpandible from "./ListaExpandible.tsx";

const datos = [
  { elemento: "Alaska", subElementos: ["Bascom"] },
  { elemento: "Connecticut", subElementos: [] },
  { elemento: "Wisconsin", subElementos: ["Oretta", "Konterra", "Guthrie"] },
  {
    elemento: "Nebraska",
    subElementos: [
      "Jennings",
      "Harviell",
      "Alfarata",
      "Bluffview",
      "Escondida",
    ],
  },
  { elemento: "Georgia", subElementos: [] },
];

function App() {
  return (
    <div>
      <h2>Lista Interactiva</h2>
      <ListaExpandible datos={datos} />
    </div>
  );
}

export default App;
