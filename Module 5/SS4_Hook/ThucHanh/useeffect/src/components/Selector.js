import React, {useEffect} from "react";
import {Component} from "react";
import {useState} from "react";

function Selector() {
    const [selected, setSelect] = useState(0);
    const [value, setValueSelect] = useState("");

    const choice = element => {
        setSelect(element.target.value);
    };

    useEffect(() => {
        switch (selected) {
            case "0":
                setValueSelect("Java");
                break;
            case "1":
                setValueSelect("JavaScript");
                break;
            case "2":
                setValueSelect("Python");
                break;
            case "3":
                setValueSelect("C/C++");
                break;
            case "4":
                setValueSelect("PHP");
                break;
            default:
        }
    }, [selected]);

    return (
        <>
            <select onChange={event => choice(event)}>
                <option value={"0"}>Moi ban lua chon</option>
                <option value={"1"}>Java</option>
                <option value={"2"}>Python</option>
                <option value={"3"}>C/C++</option>
                <option value={"4"}>PHP</option>
            </select>
            <h4>Your select : {value}</h4>
        </>
    );

}

export default Selector;