Feature: Git hub POST request Repo
All +ve and -ve API scenarios for GET repo Endpoints


Scenario: Create public repo with valid Data
	Given I use Authorization 
	And body param from file "createRepo.json"
	When I do a POST request with url "/user/repos"
	Then validate Status Code is 201