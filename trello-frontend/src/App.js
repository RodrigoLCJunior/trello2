import logo from './logo.svg';
import './App.css';
import BoardList from './components/BoardList'; // Certifique-se de que o caminho está correto

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h1>Meu Trello</h1>
      </header>
      {/* Renderizando o BoardList */}
      <BoardList />
    </div>
  );
}

export default App;
