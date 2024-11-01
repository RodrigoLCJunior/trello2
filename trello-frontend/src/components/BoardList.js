import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../styles/BoardList.css';

const BoardList = () => {
    const [boards, setBoards] = useState([]);
    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('');

    useEffect(() => {
        fetchBoards();
    }, []);

    const fetchBoards = async () => {
        try {
            const response = await axios.get('http://localhost:8080/api/boards');
            setBoards(response.data);
        } catch (error) {
            console.error("Erro ao buscar boards:", error);
        }
    };

    const createBoard = async (e) => {
        e.preventDefault();
        try {
            await axios.post('http://localhost:8080/api/boards', {
                name: title,          // Usa o nome "name" para o campo título
                descricao: description // Usa "descricao" para a descrição
            });
            setTitle(''); // Limpa o campo de título
            setDescription(''); // Limpa o campo de descrição
            fetchBoards(); // Atualiza a lista de boards
        } catch (error) {
            console.error("Erro ao criar board:", error);
        }
    };
    

    return (
        <div>
            <h2>Lista de Boards</h2>
            <form onSubmit={createBoard}>
                <input
                    type="text"
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                    placeholder="Título do Board"
                    required
                />
                <input
                    type="text"
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                    placeholder="Descrição do Board"
                    required
                />
                <button type="submit">Criar Board</button>
            </form>
            <ul>
                {boards.map(board => (
                    <li key={board.id}>{board.id}-{board.name}: {board.descricao}</li>
                ))}
            </ul>
        </div>
    );
};

export default BoardList;
