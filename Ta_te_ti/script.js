
const box= document.querySelectorAll(".box");
const result= document.querySelector(".result");


let turno= 0;
let tablerojuego= ["", "", "", "", "", "", "", "", ""];

const botonReset = document.getElementById('reset');

botonReset.addEventListener('click', () => 
  {
    console.log("Resetea el juego");
    turno= 0;
    tablerojuego= ["", "", "", "", "", "", "", "", ""];
    box.forEach((box) =>
      {
        box.innerText= "";
        result.innerText= "...";
        
      });
    console.log(tablerojuego);
    console.log(box)
    console.log(result)
});


box.forEach((box) =>
  {
    box.addEventListener('click', () =>
      {
       if(turno % 2 !== 0 && box.innerText === "" && result.innerText === "...")
       {
         box.innerText= "O";
         tablerojuego[box.dataset.index]= "O";
         turno++;
         chequearGanador(tablerojuego);
       }
        else if(turno % 2 === 0 && box.innerText === "" && result.innerText === "...")
        {
          box.innerText= "X";
          tablerojuego[box.dataset.index]= "X";
          turno++;
          chequearGanador(tablerojuego);
        }
        else
        {
          console.log("Espacio en uso");
        }
        
      }      
      )
  }
  );

function chequearGanador(tablerojuego){
  let tablero2 = [
      [tablerojuego[0], tablerojuego[1], tablerojuego[2]],
      [tablerojuego[3], tablerojuego[4], tablerojuego[5]],
      [tablerojuego[6], tablerojuego[7], tablerojuego[8]]
  ];
  
  for(let i=0; i<3; i++)
    {
      if(tablero2[i][0] === tablero2[i][1] && tablero2[i][1] === tablero2[i][2] && tablero2[i][0] !== "")
      {
        result.innerText= "Ganaste!!: " + tablero2[i][0];
      }
      if(tablero2[0][i] === tablero2[1][i] && tablero2[1][i] === tablero2[2][i] && tablero2[0][i] !== "")
      {
          result.innerText= "Ganaste!!: " + tablero2[0][i];
      }
    }
  if(tablero2[0][0] === tablero2[1][1] && tablero2[1][1] === tablero2[2][2] && tablero2[0][0] !== "")
  {
        result.innerText= "Ganaste!!: " + tablero2[1][1];
  }
  if(tablero2[0][2] === tablero2[1][1] && tablero2[1][1] === tablero2[2][0] && tablero2[0][2] !== "")
  {
      result.innerText= "Ganaste!!: " + tablero2[1][1];
  }
  if(turno === 9 && result.innerText === "...")
  {
    result.innerText= "!! Empate !!";
  }
}


