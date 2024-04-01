import React, { useState, useEffect } from 'react';

function Timer() {
    const [timer, setTimer] = useState(10);

    useEffect(() => {
        const intervalId = setInterval(() => {
            setTimer((prevTimer) => prevTimer > 0 ? prevTimer - 1 : 0);
        }, 1000);

        // Clean up effect
        return () => {
            clearInterval(intervalId);
        };
    }, []);

    useEffect(() => {
        if (timer === 0) {
            alert("Hết giờ");
        }
    }, [timer]);

    return (
        <div>
            {timer > 0 ? `Timer: ${timer}` : "Hết giờ"}
        </div>
    );
}

function App() {
    return (
        <div>
            <h1>App Component</h1>
            <Timer />
        </div>
    );
}

export default App;
