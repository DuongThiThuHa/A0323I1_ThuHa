import './App.css';
import {useState} from "react";


function App() {
    const carList = ["Lexus", "Chevrolet", "Audi"];
    const colorList = ["Red", "Green", "Blue", "White"];

    const [selectedCar, setSelectedCar] = useState({car: " ", color: ""});

    const handleSelection = (props, value) => {
        setSelectedCar((prevState) => {
            return {
                ...prevState, [props]: value
            }
        })
    }

    return (
        <>
            <h3>Select your Car</h3>
            <div>
                <span>Select a car </span>
                <select value={selectedCar.car} onChange={(e) => handleSelection("car", e.target.value)}>
                    {carList.map((value, index) => {
                        return <option key={index}>{value}</option>
                    })}
                </select>
            </div>
            <div>
                <span>Select a color </span>
                <select value={selectedCar.color} onChange={(e) => handleSelection("color", e.target.value)}>
                    {colorList.map((value, index) => {
                        return <option key={index}>{value}</option>
                    })}
                </select>
            </div>
            <h3>You selected a {selectedCar.color} - {selectedCar.car}</h3>
        </>
    );
}

export default App;
