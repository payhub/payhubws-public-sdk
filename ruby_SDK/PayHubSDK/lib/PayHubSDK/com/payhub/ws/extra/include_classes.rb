Gem.find_files("PayHubSDK/com/payhub/ws/util/**/*.rb").each { |path| require path}
Gem.find_files("PayHubSDK/com/payhub/ws/model/**/*.rb").each { |path| require path}
Gem.find_files("PayHubSDK/com/payhub/ws/api/**/*.rb").each { |path| require path}
