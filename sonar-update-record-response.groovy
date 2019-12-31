def jsonS = new groovy.json.JsonSlurper()

def request = jsonS.parseText(payload) as Map

groovy.json.JsonOutput.toJson(request)
