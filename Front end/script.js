const jsdom = require("jsdom");
const { JSDOM } = jsdom;
const fetch = require("node-fetch");
const fs = require('fs');

const dom = new JSDOM(`<!DOCTYPE html>
<html>
<head>
<title>CVE Details</title>
</head>
<body>
    <h1>CVE Details</h1>
    <table id="cve-details">
        <thead>
            <tr>
                <th>CVE ID</th>
                <th>Description</th>
                <th>Value</th>
                <th>Last Modified</th>
                <th>Published</th>
                <th>Source Identifier</th>
                <th>Vulnerable Status</th>
            </tr>
        </thead>
        <tbody>
            <!-- Data rows will be inserted here using JavaScript -->
        </tbody>
    </table>
</body>
</html>`);

const tableBody = dom.window.document.querySelector('#cve-details tbody');

fetch('http://localhost:8080/cves/details') // Use full URL if necessary
    .then(response => response.json())
    .then(data => {
        data.forEach(item => {
            const row = tableBody.insertRow();
            row.insertCell(0).textContent = item.id;
            row.insertCell(1).textContent = item.descriptions.map(desc => desc.value).join(', ');
            row.insertCell(2).textContent = item.value; // Assuming 'value' is a direct property of the item
            row.insertCell(3).textContent = item.lastModified;
            row.insertCell(4).textContent = item.published;
            row.insertCell(5).textContent = item.sourceIdentifier;
            row.insertCell(6).textContent = item.vulnStatus;
        });

        // Save the modified HTML to a file
        fs.writeFileSync('output.html', dom.window.document.documentElement.outerHTML);

        console.log('The modified HTML has been saved to output.html');
        console.log('Open output.html in a web browser to view the table.');
    })
    .catch(error => console.error('Error fetching data:', error));
