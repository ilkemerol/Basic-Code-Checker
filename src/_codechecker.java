import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _codechecker {
	String _oneline = "";
	public _codechecker(String _getCode){
		_oneline = _getCode;
	}
	public String operation(){
		int _lineNumber = 1;
		int _openCurle = 0;
		int _closeCurle = 0;
		int _openBracket = 0;
		int _closeBracket = 0;
		boolean _err = false;
		String result = "---Your code's report---" + System.lineSeparator();
		for(String _line: _oneline.split("\\n")){
			if(!_line.trim().isEmpty()){
		//while(_line != null){
			//System.out.println(_line);
				if(!_line.contains(";")){
					if(_line.contains("if") || _line.contains("for") || _line.contains("while") || _line.contains("}") || _line.contains("{") || _line.contains("//") || _line.contains("@Override") || _line.contains("/*") || _line.contains("*/")){
						//no_problem
					}
					else{
						//System.out.println("Error in line: " + _lineNumber);
						result += "> Error in line: " + _lineNumber + System.lineSeparator();
						_err = true;
					}
				}
				if(_line.contains(";") && !_line.contains("//")){
					char _control = ';';
					int _count = 0;
					for(char ch: _line.toCharArray()){
						if(ch == _control){
							_count++;
						}
					}
					if(_count != 1 && !_line.contains("for")){
						//System.out.println("Error in line: " + _lineNumber);
						result += "> Error in line: " + _lineNumber + " - more than one ';' symbol." + System.lineSeparator();
						_err = true;
					}
				}
				if(_line.contains("{")){
					_openCurle++;
				}
				if(_line.contains("}")){
					_closeCurle++;
				}
				if(_line.contains("(")){
					_openBracket++;
				}
				if(_line.contains(")")){
					_closeBracket++;
				}
				//_line = reader.readLine();
				_lineNumber++;
			}
			else{
				_lineNumber++;
			}
		}
		//Check Curle
		if(_openCurle == _closeCurle){
			//System.out.println("---Reports---");
			//System.out.println("No curle brackets error!");
			//GUI
			result += ">No curle brackets error!" + System.lineSeparator();
		}
		else if(_openCurle != _closeCurle){
			//System.out.println("Curle brackets error!");
			result += ">Curle brackets error!" + System.lineSeparator();
		}
		if(_openBracket == _closeBracket){
			//System.out.println();
			//System.out.println("No brackets error!");
			result += ">No brackets error!" + System.lineSeparator();
		}
		else if(_openBracket != _closeBracket){
			//System.out.println("Brackets error!");
			result += ">Brackets error!" + System.lineSeparator();
		}
		if(!_err){
			//System.out.println();
			//System.out.println("No Error, Good Work!");
			result += "No Error, Good Work!" + System.lineSeparator();
		}
		//System.out.print(result);
		return result;
	}
	//public static void main(String[] args) throws IOException{
		//BufferedReader reader = new BufferedReader(new FileReader("code"));
		//String _line = "";
	//}
}
