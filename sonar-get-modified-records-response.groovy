class CAResponse {
  int totalRecords;
  List<CAResponseResult> result;
}
class CAResponseResult {
  String id;
  Map fields;
}

def jsonS = new groovy.json.JsonSlurper()
def appResponse = jsonS.parseText(payload) as Map

def _response = new CAResponse();
_response.totalRecords = appResponse.total;
_resultArray = new ArrayList();
for(def issue:appResponse.issues) {
  def _record = new CAResponseResult();
  _record.id = issue.key;
  def _fields = new HashMap();
  for(Map.Entry<String,Object> issueField:issue.entrySet()) {
      _fields.put(issueField.key,issueField.value)
  }
  _record.fields = _fields;
  _resultArray.add(_record);
}

_response.result = _resultArray




groovy.json.JsonOutput.toJson(_response)
