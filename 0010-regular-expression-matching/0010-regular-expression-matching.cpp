class Solution {
public:
    bool isMatch(string s, string p) {
        int n = s.length(), m = p.length();
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, -1));
        return solve(s, p, n - 1, m - 1, dp);
    }

private:
    bool solve(string& s, string& p, int i, int j, vector<vector<int>>& dp) {
        if (i < 0 && j < 0) return true;
        if (j < 0) return false;
        if (i < 0) {
            for (int k = 0; k <= j; k += 2)
                if (k + 1 >= p.size() || p[k + 1] != '*') return false;
            return true;
        }

        if (dp[i][j] != -1) return dp[i][j];

        if (p[j] == '*') {
            bool zeroOccur = solve(s, p, i, j - 2, dp);
            bool oneOrMore = false;
            if (p[j - 1] == s[i] || p[j - 1] == '.') oneOrMore = solve(s, p, i - 1, j, dp);
            return dp[i][j] = zeroOccur || oneOrMore;
        }

        if (s[i] == p[j] || p[j] == '.') return dp[i][j] = solve(s, p, i - 1, j - 1, dp);
        return dp[i][j] = false;
    }
};