import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

const name = "U Hoi Map";

const root = ReactDOM.createRoot(document.getElementById('root'));
let style;
root.render(
    //Nhúng tên của bạn vào React Element tạo bởi React.createElement
    // React.createElement("h1", {style: {textAlign: "center"}}, name);


    //Nhúng tên của bạn vào React Element tạo bởi JSX
    <h1 style={{textAlign: "center"}}>{name}</h1>
)
;

reportWebVitals();
