import { useNavigate } from "react-router-dom";

function App() {
  const navigate = useNavigate();

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h1>Bienvenido a la Aplicación</h1>
      <p>Por favor, elige una opción:</p>
      <div style={{ marginTop: "30px" }}>
        <button
          style={{ marginRight: "20px", padding: "10px 20px" }}
          onClick={() => navigate("/register")}
        >
          Registrarse
        </button>
        <button
          style={{ padding: "10px 20px" }}
          onClick={() => navigate("/login")}
        >
          Iniciar Sesión
        </button>
      </div>
    </div>
  );
}

export default App;
