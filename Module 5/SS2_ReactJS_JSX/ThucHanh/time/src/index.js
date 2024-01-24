import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';

const tick = () => {
    const root = ReactDOM.createRoot(document.getElementById('root'));
    root.render(
        <div>
            <h1>Hello Ha U</h1>
            <h2>It is {new Date().toLocaleDateString()}.</h2>
        </div>
    );
};

setInterval(tick, 1000);

reportWebVitals();
