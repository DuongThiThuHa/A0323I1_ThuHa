import React from "react";
import {useState} from "react";
import {Component} from "react";

function Counter() {
    //khoi tao 1 bien useState theo cu phap va co gia tri ban dau = 0
    const [count, setCount] = useState(0);

    // Arrow Function xu ly su kien
    const handleClick = () => {
        const newValue = count + 1;
        // cap nhap lai du lieu tren State
        setCount(newValue);
    };

    return (
        <>
            <h1>Gia tri: {count}</h1>
            <div>
                <button onClick={handleClick}>Tang</button>
            </div>
        </>
    )
}
export default Counter;