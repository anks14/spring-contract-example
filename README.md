# spring-contract-example

Two objectives of project:

1) Test input json validation defining a json schema in src/main/resources/schema.json and test with passing valid/invalid json data to get
validation failures which violate schema definition.

http://localhost:4444/testSchema?shouldPassValidation=true uses valid data and

http://localhost:4444/testSchema?shouldPassValidation=false uses invalid data

So pretty simple huh! Not much Jazz there :)

2) Write api contracts for tests to solve issues of contracts breaking on consumer/producer side, missing/change content 
type etc. I have used spring cloud contract and have used one example of groovy style contract and another of yaml. So you
can take your pick :P
Contract definitions can be found at src/main/test/contracts

Based on contracts above tests get auto-generated (cool isnt it :) ). It installs a wiremock stub to local m2. So if mvn 
package fails on first try. Run mvn install with skip test once and then try!!



