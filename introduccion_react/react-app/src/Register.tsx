import { useNavigate } from "react-router-dom";

function Register() {
  const navigate = useNavigate();

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    // Aquí puedes agregar la lógica de registro
    alert("Registro exitoso");
    navigate("/");
  };

  return (
    <div style={{ maxWidth: "400px", margin: "50px auto" }}>
      <h2>Formulario de Registro</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label className="form-label">Nombre de usuario</label>
          <input type="text" className="form-control" required />
        </div>
        <div className="mb-3">
          <label className="form-label">Correo electrónico</label>
          <input type="email" className="form-control" required />
        </div>
        <div className="mb-3">
          <label className="form-label">Contraseña</label>
          <input type="password" className="form-control" required />
        </div>
        <button type="submit" className="btn btn-primary">
          Registrarse
        </button>
        <button
          className="btn btn-secondary ms-2"
          onClick={() => navigate("/")}
        >
          Cancelar
        </button>
      </form>
    </div>
  );
}

export default Register;
