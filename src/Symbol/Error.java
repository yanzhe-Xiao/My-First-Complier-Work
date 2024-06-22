package Symbol;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

/**
 * 收集记录错误信息。
 */
public class Error {
    // 使用枚举来定义错误类型
    public static enum ErrorType {
        REDEFINED, UNDEFINED, TYPE_ERROR, OVERFLOW, OUT_OF_INDEX
    }

    private Map<ErrorType, Integer> errorCounts;
    private ArrayList<String> errorDetails;
    private String lineInfo;
    public Error() {
        this.errorCounts = new EnumMap<>(ErrorType.class);
        this.errorDetails = new ArrayList<>();
        // 初始化错误计数
        for (ErrorType errorType : ErrorType.values()) {
            errorCounts.put(errorType, 0);
        }
    }

    /**
     * 添加错误信息
     * @param lineInfo 行号
     * @param typeName 类型名
     * @param name 名称
     * @param error 错误类型
     * @param expectedType 期望类型
     * @param errorInfo 错误信息
     */
    public void addError(String lineInfo, String typeName, String name, ErrorType error, String expectedType,String errorInfo) {
        StringBuilder errorDetail = new StringBuilder();
        this.lineInfo = lineInfo;
        errorDetail.append("Line ").append(lineInfo)
                .append(": ").append(name).append(" of type ").append(typeName)
                .append(" - ").append(error.name().toLowerCase())
                .append(expectedType != null ? ", Expected: " + expectedType : "")
                .append(", \n").append(errorInfo);

        errorDetails.add(errorDetail.toString());
        errorCounts.put(error, errorCounts.get(error) + 1);
    }

    /**
     * 获取错误信息
     * @return 错误信息
     */
    public String getErrString() {
        StringBuilder sb = new StringBuilder();
        for (String error : errorDetails) {
            sb.append(error).append("\n");
        }
        return sb.toString();
    }

    /**
     * 获取特定错位类型错误总数
     * @param errorType 错误类型
     * @return 错误总数
     */
    public int getErrorCount(ErrorType errorType) {
        return errorCounts.get(errorType);
    }

    /**
     * 获取错误总数
     * @return 错误总数
     */
    public int getErrorCount() {
        int count = 0;
        for (ErrorType errorType : ErrorType.values()) {
            count += errorCounts.get(errorType);
        }
        return count;
    }

    public String getLineInfo() {
        return lineInfo;
    }
}