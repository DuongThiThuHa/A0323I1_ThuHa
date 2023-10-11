<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<form action="/customer?action=create" method="post">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Birthday</th>
            <th scope="col">Gender</th>
            <th scope="col">Card ID</th>
            <th scope="col">Phone</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Customer Type</th>
        </tr>
        </thead>

        <tbody>
        <tr>
            <td>
                <input name="id" type="number">
            </td>
            <td>
                <input name="name" type="text">
            </td>
            <td>
                <input name="birthday" type="text">
            </td>
            <td>
                <div name="gender" class="form-check">
                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                    <label class="form-check-label" for="flexRadioDefault1">
                        Nữ
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
                    <label class="form-check-label" for="flexRadioDefault2">
                        Nam
                    </label>
                </div>
            </td>
            <td>
                <input name="cardID" type="text">
            </td>
            <td>
                <input name="phone" type="text">
            </td>
            <td>
                <input name="email" type="text">
            </td>
            <td>
                <input name="address" type="text">
            </td>
            <td>
                <div name="CustomerType"  class="form-check">
                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault01">
                    <label class="form-check-label" for="flexRadioDefault1">
                        Diamond
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault02"
                           checked>
                    <label class="form-check-label" for="flexRadioDefault2">
                        Platinum
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault03"
                           checked>
                    <label class="form-check-label" for="flexRadioDefault2">
                        Gold
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault04"
                           checked>
                    <label class="form-check-label" for="flexRadioDefault2">
                        Silver
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault05"
                           checked>
                    <label class="form-check-label" for="flexRadioDefault2">
                        Member
                    </label>
                </div>
            </td>
        </tr>

        <tr>
            <td>
                <button type="submit">Create</button>
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
