Developer Assessment

Starting the BankAccountService
To start this web service, install Maven and execute the following command

mvn spring-boot:run
Once the web service is started, it can be reached at

http://localhost:9092/bankaccountservice/api/

REST Endpoints

The following REST endpoints are available upon deployment of  BankAccountService RESP API



<dl>
  <dt>Customer</dt>
   
</dl>

<table>
    <thead>
      <tr>
        <th>HTTP Verb</th>
        <th>URL</th>
        <th>Description</th>
        <th>Status Codes</th>
      </tr>
    </thead>
    <tbody>
        <tr>
            <td>POST</td>
            <td>localhost:9092/bankaccountservice/api/customer</td>
            <td><code>Creates a new Customer based on the payload contained in the request body</code></td>
            <td><code>201 Created if Customer successfully created</code></td>
        </tr>
        <tr>
            <td>GET</td>
            <td>localhost:9092/bankaccountservice/api/customer/{customerId}</td>
            <td><code>Obtains the Customer corresponding to the supplied Customer ID</code></td>
            <td><code>200 OK if order exists
404 Not Found if order does not exist</code></td>
        </tr>
    </tbody>
  </table>
  
  <dl>
  <dt>Account</dt>
   
</dl>

<table>
    <thead>
       <tr>
        <th>HTTP Verb</th>
        <th>URL</th>
        <th>Description</th>
        <th>Status Codes</th>
      </tr>
    </thead>
    <tbody>
        <tr>
            <td>"XML HTTP request"</td>
            <td>pascalCase</td>
            <td><code>XmlHttpRequest</code></td>
            <td><code>XMLHTTPRequest</code></td>
        </tr>
        <tr>
            <td>"new customer ID"</td>
            <td>camelCase</td>
            <td><code>newCustomerId</code></td>
            <td><code>newCustomerID</code></td>
        </tr>
    </tbody>
  </table>
  <dl>
  <dt>Transaction</dt>
   
</dl>

<table>
    <thead>
       <tr>
        <th>HTTP Verb</th>
        <th>URL</th>
        <th>Description</th>
        <th>Status Codes</th>
      </tr>
    </thead>
    <tbody>
        <tr>
            <td>"XML HTTP request"</td>
            <td>pascalCase</td>
            <td><code>XmlHttpRequest</code></td>
            <td><code>XMLHTTPRequest</code></td>
        </tr>
        <tr>
            <td>"new customer ID"</td>
            <td>camelCase</td>
            <td><code>newCustomerId</code></td>
            <td><code>newCustomerID</code></td>
        </tr>
    </tbody>
  </table>
  
