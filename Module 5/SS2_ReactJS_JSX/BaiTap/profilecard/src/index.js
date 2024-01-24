import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import "bootstrap/dist/css/bootstrap.css";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <div>
        <div className="card">
            <img src="https://webdamn.com/demo/forum-php-mysql-demo/images/user-avatar.png" className="card-img-top"/>
            <div className="card-body">
                <h5 className="card-title">Profile Card</h5>
                <p className="card-text">Hello .</p>
                <button>Sign In</button>
            </div>
        </div>
    </div>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
