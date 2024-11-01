import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Card = ({ taskListId }) => {
    const [cards, setCards] = useState([]);

    useEffect(() => {
        const fetchCards = async () => {
            const response = await axios.get(`http://localhost:8080/api/tasklists/${taskListId}/cards`);
            setCards(response.data);
        };

        fetchCards();
    }, [taskListId]);

    return (
        <div>
            <h2>Cards</h2>
            <ul>
                {cards.map(card => (
                    <li key={card.id}>{card.title}</li>
                ))}
            </ul>
        </div>
    );
};

export default Card;
