class Bracket {
    char type;
    int position;

    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }
}
