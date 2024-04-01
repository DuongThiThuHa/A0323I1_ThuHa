// Sử dụng Props trong ComponentAssignment
// import Welcome from './components/Welcome';
// function App() {
//   return (
//       <div className="App">
//         <Welcome name="Thu Ha" />
//       </div>
//   );
// }
// export default App;


// Xây dựng Class component
// import AddComponent from './components/AddComponent';
// function App() {
//     return (
//         <AddComponent firstNumber={20} secondNumber={2} />
//     );
// }
// export default App;


// Xây dựng Function component
// import AddComponent from './components/AddComponent';
// function App() {
//     return (
//         <AddComponent firstNumber={24} secondNumber={12} />
//     );
// }
// export default App;


// Đếm số lần click vào Button tăng/giảm (State + event)
// import {Component} from "react";
//
// class App extends Component {
//     constructor(props) {
//         super(props);
//         this.state = {
//             num: 0
//         };
//     }
//
//     increase = () => {
//         this.setState({num: this.state.num + 1});
//     };
//     decrease = () => {
//         this.setState({num: this.state.num - 1});
//     };
//
//     render() {
//         return (
//             <div style={{textAlign: "center", padding: 30}}>
//                 <button onClick={this.decrease}>Decrease (-)</button>
//                 <span style={{padding: 20}}>{this.state.num}</span>
//                 <button onClick={this.increase}>Increase (+)</button>
//             </div>
//         );
//     }
// }
//
// export default App;


// Đổi màu nền component sau khi xuất hiện
// import React from "react";
// import {Component} from "react";
//
// class App extends Component {
//     constructor(props) {
//         super(props);
//         this.state = {
//             color: 'lightblue'
//         };
//     }
//
//     componentDidMount() {
//         setTimeout(() => {
//             this.setState({color: 'lightgreen'});
//         }, 2000);
//     }
//
//
//     render() {
//         return(
//             <div style={{
//                 backgroundColor:this.state.color,
//                 paddingTop: 30,
//                 width: 400,
//                 height:80,
//                 margin: 'auto'
//             }}>
//
//             </div>
//         );
//     }
// }
//
// export default App;


// Hiện thông báo trước khi Component ẩn
// import React, { Component } from 'react';
// import Hello from "./components/Hello";
//
// class App extends Component {
//     constructor(props) {
//         super(props);
//         this.state = {
//             display: true
//         };
//     }
//
//     delete = () => {
//         this.setState({ display: false });
//     };
//
//     render() {
//         let comp;
//         if (this.state.display) {
//             comp = <Hello />;
//         }
//         return (
//             <div style={{ textAlign: 'center' }}>
//                 {comp}
//                 <button onClick={this.delete}>
//                     Delete the component
//                 </button>
//             </div>
//         );
//     }
// }
//
// export default App;


// Kiểm tra User Login/Logout
// import React from "react";
// import {Component} from "react";
// import Home from "./components/Home";
//
// class App extends Component {
//     constructor(props) {
//         super(props);
//         this.state = {
//             isLoggedIn: false
//         }
//     }
//
//     handleLogIn = () => {
//         this.setState({isLoggedIn: true})
//     }
//
//     handleLogOut = () => {
//         this.setState({isLoggedIn: false})
//     }
//
//     render() {
//         const {isLoggedIn} = this.state
//         if (isLoggedIn) return (
//             <Home onLogOut={this.handleLogOut}/>
//         )
//         return (
//             <div style={{textAlign: 'center'}}>
//                 <h1>Please LogIn</h1>
//                 <button onClick={this.handleLogIn}>Log In</button>
//             </div>
//         )
//     }
// };
//
// export default App;