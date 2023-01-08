
import './App.css';
import PersoanaComponent from "./components/PersoanaComponent";
import CarteComponent from "./components/CarteComponent";
import ImprumutComponent from "./components/ImprumutComponent";
import AutorComponent from "./components/AutorComponent";
import LegendaComponent from "./components/LegendaComponent";

function App() {


  return (
      <div className="background">
          <LegendaComponent/>
          <PersoanaComponent/>
          <CarteComponent/>
          <ImprumutComponent/>
          <AutorComponent/>

      </div>


  );
}

export default App;
