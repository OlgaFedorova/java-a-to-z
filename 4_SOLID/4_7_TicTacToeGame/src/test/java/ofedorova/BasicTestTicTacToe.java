package ofedorova;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class consist public basic method for using in test-classes..
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 28.11.2016
 */
public class BasicTestTicTacToe {

    /**
     * Method returns string for output console.
     *
     * @return string for output console.
     */
    public String getOuputConsoleString() {
        StringBuilder result = new StringBuilder();
        result.append("Input size of area game:\n");
        result.append("Input count for win of area game:\n");
        result.append("Input name of user:\n");
        result.append("Select symbol for user X or O\n");
        result.append("User is first gamer? Y/N\n");
        result.append("Step of Gamer{name='Computer', symbol=O}\n");
        result.append("   0 1 2\n");
        result.append(" 0|_|_|_|\n");
        result.append(" 1|_|O|_|\n");
        result.append(" 2|_|_|_|\n");
        result.append("Step of Gamer{name='Olga', symbol=X}\n");
        result.append("Input coordinate X:\n");
        result.append("Input coordinate Y:\n");
        result.append("   0 1 2\n");
        result.append(" 0|X|_|_|\n");
        result.append(" 1|_|O|_|\n");
        result.append(" 2|_|_|_|\n");
        result.append("Step of Gamer{name='Computer', symbol=O}\n");
        result.append("   0 1 2\n");
        result.append(" 0|X|_|_|\n");
        result.append(" 1|O|O|_|\n");
        result.append(" 2|_|_|_|\n");
        result.append("Step of Gamer{name='Olga', symbol=X}\n");
        result.append("Input coordinate X:\n");
        result.append("Input coordinate Y:\n");
        result.append("   0 1 2\n");
        result.append(" 0|X|_|_|\n");
        result.append(" 1|O|O|X|\n");
        result.append(" 2|_|_|_|\n");
        result.append("Step of Gamer{name='Computer', symbol=O}\n");
        result.append("   0 1 2\n");
        result.append(" 0|X|O|_|\n");
        result.append(" 1|O|O|X|\n");
        result.append(" 2|_|_|_|\n");
        result.append("Step of Gamer{name='Olga', symbol=X}\n");
        result.append("Input coordinate X:\n");
        result.append("Input coordinate Y:\n");
        result.append("   0 1 2\n");
        result.append(" 0|X|O|_|\n");
        result.append(" 1|O|O|X|\n");
        result.append(" 2|_|X|_|\n");
        result.append("Step of Gamer{name='Computer', symbol=O}\n");
        result.append("   0 1 2\n");
        result.append(" 0|X|O|O|\n");
        result.append(" 1|O|O|X|\n");
        result.append(" 2|_|X|_|\n");
        result.append("Step of Gamer{name='Olga', symbol=X}\n");
        result.append("Input coordinate X:\n");
        result.append("Input coordinate Y:\n");
        result.append("   0 1 2\n");
        result.append(" 0|X|O|O|\n");
        result.append(" 1|O|O|X|\n");
        result.append(" 2|_|X|X|\n");
        result.append("Step of Gamer{name='Computer', symbol=O}\n");
        result.append("   0 1 2\n");
        result.append(" 0|X|O|O|\n");
        result.append(" 1|O|O|X|\n");
        result.append(" 2|O|X|X|\n");
        result.append("Game over. Winner is Gamer{name='Computer', symbol=O}");
        return result.toString();
    }

    /**
     * Method returns string in file "OutputConsoleUserInterface.txt".
     *
     * @return string in file "OutputConsoleUserInterface.txt".
     * @throws IOException exception to work with file.
     */
    public String getStingInFileOutputConsoleUserInterface() throws IOException {
        final StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/java/ofedorova/OutputConsoleUserInterface.txt"));) {
            String readString = reader.readLine();
            int index = 0;
            while (readString != null) {
                if (index != 0) {
                    result.append("\n");
                }
                result.append(readString);
                readString = reader.readLine();
                index++;
            }
        }
        return result.toString();
    }

}
