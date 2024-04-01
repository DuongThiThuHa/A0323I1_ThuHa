import './App.css';
import StudentList from "./components/student/StudentList";
import DemoState from "./components/DemoState";
import {useState} from "react";

function App() {
    const [className, setClassName] = useState("")
    const changeNameClass = (event) => {
        console.log(1)
        setClassName(event.target.value);
        console.log(className)
    }
    return (
        <>
            {/*<input onChange={(event) => changeNameClass()}/>*/}
            <input onChange={changeNameClass}/>
            <StudentList nameClass={className}/>
            <DemoState/>
        </>
    );
}

export default App;
