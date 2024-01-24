import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
   // Sử dụng hàm navigator.userAgent để lấy thông tin trình duyệt
    <h4>Browser's details: {navigator.userAgent}</h4>
);

reportWebVitals();
