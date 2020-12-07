# ConnectALL SONAR Adapter 

ConnectALL Sonar Adapter is developed as an extension to the Universal adapter capability of ConnectALL. This adapter specifications will let the user use Sonar with Webhooks to read and write the data in to Sonar. 

Please refer to https://wiki.connectall.com/ca/latest/adapters/universal-adapter for more information

# Usecase

A developer will run the sonar analysis in local build or a CI build that publishes the Security vulnerabilities to the Sonarqube project. The issues reported by Sonar analysis will be synchronized back to Jira, Azure DevOps or other work tracking systems. 

# How to use

> In order to use the Sonar adapter you will need to get the license from ConnectALL sales team. Please reach out to sales@connectall.com for licenses and quotes.

## Import specifications
* Import *-adapter-descriptor.json in to ConnectALL using "Install custom adapter" feature. Customize the descriptor after importing to fit your personal boards and custom fields
* View the transformation specs and open the transformation spec page
* Choose the operation, adapter type and create draft specifications
* Copy the content of {adaptertype}-{operation}-[request|response].[groovy|jolt] in to the text area
* Test the specifications and save them as Active

## Define application links
* Create an application link in ConnectALL between Sonar and a destination application of your choice
* Navigate to `Configuration -> Connections` screen and create a new connection to Sonar like `https://localhost:9000` as the endpoint
* In the Entity mapping tab under Advanced Properties choose "Sync Type" as POLL
* In the WebHook Grid use the templates below for each operation

> Note: CREATE abd UPDATE operations are not supported for now. So, you will not be able to create new Vulnerabilities or Security issues in Sonarqube

|Operation|API Method|Template|
|--- | --- | ---|
|QUERY MODIFIED RECORDS|GET|api/issues/search?components=${project}&types=${Type}&createdAfter=${last-modified-time}|
|READ RECORD BY ID|GET|api/issues/search?issues=${recordId}|
|CREATE RECORD|POST|api/issues/search?issues=${recordId}|
|UPDATE RECORD|PUT|api/issues/search?issues=${recordId}|


