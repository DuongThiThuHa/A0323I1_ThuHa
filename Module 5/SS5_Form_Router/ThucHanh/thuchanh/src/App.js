// Form đăng ký tài khoản mới

// import './App.css';
// import {useState} from "react";
// export default function App() {
//     const [form, setForm] = useState({});
//
//     function handleChange(event) {
//         setForm({
//             ...form,
//             [event.target.name]: event.target.value
//         });
//     }
//
//     function handleSubmit() {
//         const isValid = form.username && form.email && form.password && form.confirmPassword;
//         alert(isValid ? "Dang ky thanh cong" : "Dang ky that bai");
//     }
//
//     return (
//         <>
//             <h1>Sign Up</h1>
//             <table>
//                 <tr>
//                     <td>
//                         <th>Username</th>
//                         <input
//                             name="username"
//                             value={form.username || ""}
//                             onChange={handleChange}
//                         />
//                     </td>
//                 </tr>
//                 <tr>
//                     <td>
//                         <th>Email</th>
//                         <input
//                             name="email"
//                             value={form.email || ""}
//                             onChange={handleChange}
//                         />
//                     </td>
//                 </tr>
//                 <tr>
//                     <td>
//                         <th>Password</th>
//                         <input
//                             type="password"
//                             name="password"
//                             value={form.password || ""}
//                             onChange={handleChange}
//                         />
//                     </td>
//                 </tr>
//                 <tr>
//                     <td>
//                         <th>Confirm Password</th>
//                         <input
//                             type="password"
//                             name="confirmPassword"
//                             value={form.confirmPassword || ""}
//                             onChange={handleChange}
//                         />
//                     </td>
//                 </tr>
//             </table>
//           <button onClick={handleSubmit}>Submit</button>
//         </>
//     )
//         ;
// }
// -------------------------------------

// Validate Form đăng ký

import React, { useState } from "react";
import './App.css';
export default function Validate() {
  const [form, setForm] = useState({});

  const MessageError = {
    username: "Username error",
    email: "Email error",
    password: "Password error",
    confirmPassword: "Confirm Password must be the same"
  }

  const Regex = {
    username: "^[a-zA-Z]{2,}$",
    email: "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$",
    password: "^[a-zA-Z0-9!@#\$%\^\&*\)\(+=._-]{6,}$"
  }

  function handleChange(event) {
    let error = "";
    if (event.target.name === 'confirmPassword') {
      error = event.target.value === form.password?.value ? "" : MessageError[event.target.name];
    } else {
      const regex = new RegExp(Regex[event.target.name]);
      error = regex.test(event.target.value) ? "" : MessageError[event.target.name];
    }
    setForm({
      ...form,
      [event.target.name]: { value: event.target.value, error: error }
    });
  }


  function handleSubmit() {
    const isFilled = form.username?.value && form.email?.value && form.password?.value && form.confirmPassword?.value;
    const isError = form.username?.error || form.email?.error || form.password?.error || form.confirmPassword?.error;
    alert(isFilled && !isError ? "Đăng ký thành công" : "Đăng ký thất bại");
  }

  return (
      <>
        <h1>Sign up</h1>
        <table>
          <tbody>
          <tr className={`custom-input ${form.username?.error && "custom-input-error"}`}>
            <td>Username</td>
            <td><input type="text" name='username' value={(form.username && form.username.value) || ""}
                       onChange={handleChange} /></td>
            {form.username && form.username.error && (
                <td><p style={{ color: "red" }} className="error">{form.username.error}</p></td>)}
          </tr>

          <tr className={`custom-input ${form.email?.error && "custom-input-error"}`}>
            <td>Email</td>
            <td><input type="text" name='email' value={(form.email && form.email.value) || ""}
                       onChange={handleChange} /></td>
            {form.email && form.email.error && (
                <td><p style={{ color: "red" }} className="error">{form.email.error}</p></td>)}
          </tr>

          <tr className={`custom-input ${form.password?.error && "custom-input-error"}`}>
            <td>Password</td>
            <td><input type="password" name='password' value={(form.password && form.password.value) || ""}
                       onChange={handleChange} /></td>
            {form.password && form.password.error && (
                <td><p style={{ color: "red" }} className="error">{form.password.error}</p></td>)}
          </tr>

          <tr className={`custom-input ${form.confirmPassword?.error && "custom-input-error"}`}>
            <td>Confirm Password</td>
            <td><input type="password" name='confirmPassword' value={(form.confirmPassword && form.confirmPassword.value) || ""}
                       onChange={handleChange} /></td>
            {form.confirmPassword && form.confirmPassword.error && (
                <td><p style={{ color: "red" }} className="error">{form.confirmPassword.error}</p></td>)}
          </tr>
          </tbody>
        </table>

        <button onClick={handleSubmit}>Submit</button>
      </>
  );
}

// Validate Form Login
// import React from "react";
// import {useState} from "react";
// import './App.css';
//
// export default function Validate() {
//     // const MessError = {
//     //     email: "Email error",
//     //     password: "Password error"
//     // };
//     //
//     // const Regex = {
//     //     email: "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-].[a-zA-Z0-9-.]+$",
//     //     password: "[a-zA-Z0-9!@#\$%\^\&*\)\(+=._-]{6,}$"
//     // };
//     //
//     // const [form, setForm] = useState({});
//     //
//     // function handleChange(event) {
//     //     let error = Regex[event.target.name].test(event.target.value)
//     //         ? ""
//     //         : MessError[event.target.name];
//     //     setForm({
//     //         ...form,
//     //         [event.target.name]: { value: event.target.value, error: error }
//     //     });
//     // }
//     //
//     // function handleSubmit() {
//     //     const isFilled =
//     //         form.email && form.email.value && form.password && form.password.value;
//     //     const isError = isFilled && (form.email.error || form.password.error);
//     //     alert(
//     //         isFilled && !isError
//     //             ? "Dang nhap thanh cong!"
//     //             : "Dang nhap that bai!"
//     //     );
//     // }
//     //
//     // return (
//     //     <div>
//     //         <h1>Login</h1>
//     //         <form>
//     //             <div
//     //                 className={`custom-input ${form.email && form.email.error && "custom-input-error"}`}
//     //             >
//     //                 <label>Email </label>
//     //                 <input name="email" value={(form.email && form.email.value) || ""} onChange={handleChange}
//     //                 />
//     //                 {form.email && form.email.error && (
//     //                     <p className="error">Email error</p>
//     //                 )}
//     //             </div>
//     //             <div
//     //                 className={`custom-input ${form.password && form.password.error && "custom-input-error"}`}
//     //             >
//     //                 <label>Password </label>
//     //                 <input type="password" name="password" value={(form.password && form.password.value) || ""}
//     //                        onChange={handleChange}
//     //                 />
//     //                 {form.password && form.password.error && (
//     //                     <p className="error">Password error</p>
//     //                 )}
//     //             </div>
//     //             <button type="button" onClick={handleSubmit}>Submit</button>
//     //         </form>
//     //     </div>
//     // );
//
//     const MessError = {
//         email: "Email error",
//         password: "Password error"
//     };
//
//     const Regex = {
//         email: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
//         password: /^[a-zA-Z0-9!@#\$%\^\&*\)\(+=._-]{6,}$/
//     };
//
//     const [form, setForm] = useState({});
//
//     function handleChange(event) {
//         let error = Regex[event.target.name].test(event.target.value)
//             ? ""
//             : MessError[event.target.name];
//         setForm({
//             ...form,
//             [event.target.name]: { value: event.target.value, error: error }
//         });
//     }
//
//     function handleSubmit() {
//         const isFilled =
//             form.email && form.email.value && form.password && form.password.value;
//         const isError = isFilled && (form.email.error || form.password.error);
//         alert(
//             isFilled && !isError
//                 ? "Login in successfully!!!"
//                 : "Please fill out all the fields!!!"
//         );
//     }
//
//     return (
//         <div>
//             <h1>Login</h1>
//             <form>
//                 <div
//                     className={`custom-input ${form.email &&
//                     form.email.error &&
//                     "custom-input-error"}`}
//                 >
//                     <label>Email </label>
//                     <input
//                         name="email"
//                         value={(form.email && form.email.value) || ""}
//                         onChange={handleChange}
//                     />
//                     {form.email && form.email.error && (
//                         <p className="error">Email error</p>
//                     )}
//                 </div>
//                 <div
//                     className={`custom-input ${form.password &&
//                     form.password.error &&
//                     "custom-input-error"}`}
//                 >
//                     <label>Password </label>
//                     <input
//                         type="password"
//                         name="password"
//                         value={(form.password && form.password.value) || ""}
//                         onChange={handleChange}
//                     />
//                     {form.password && form.password.error && (
//                         <p className="error">Password error</p>
//                     )}
//                 </div>
//                 <button type="button" onClick={handleSubmit}>
//                     Submit
//                 </button>
//             </form>
//         </div>
//     );
// }