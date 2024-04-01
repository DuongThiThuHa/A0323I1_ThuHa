// import StudentList from "./Components/Students/StudentList";
//
// function App() {
//     let className = "A03";
//     const changeNameClass = (event) => {
//         className = event.target.value;
//         console.log(className);
//     }
//   return (
//     <>
//         <StudentList nameClass={className}/>
//     </>
//   );
// }
//
// export default App;

// SS5
import CreateStudent from "./Components/Students/CreateStudent";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import 'react-toastify/dist/ReactToastify.css';
import {ToastContainer} from "react-toastify";
import StudentList from "./Components/Students/StudentList";
import React from "react";
import {EditStudent} from "./Components/Students/EditStudent";

function App() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route exact path="/student" element={<StudentList />} />
                    <Route exact path="/student/create" element={<CreateStudent />} />
                    <Route exact path="/student/update/:id" element={<EditStudent />} />
                </Routes>
            </BrowserRouter>
            <ToastContainer/>
        </>
    );
}

export default App;