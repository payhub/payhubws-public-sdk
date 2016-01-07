# coding: utf-8
lib = File.expand_path('../lib', __FILE__)

$LOAD_PATH.unshift(lib) unless $LOAD_PATH.include?(lib)
require 'PayHubSDK/version'

Gem::Specification.new do |spec|
  spec.name          = "PayHubSDK"
  spec.version       = PayHubSDK::VERSION
  spec.authors       = ["Agustin Breit"]
  spec.email         = ["agustinbreit@gmail.com"]

  spec.summary       = "PayHub Ruby SDk"
  spec.description   = "PayHub Ruby SDk"


  # Prevent pushing this gem to RubyGems.org by setting 'allowed_push_host', or
  # delete this section to allow pushing this gem to any host.
  if spec.respond_to?(:metadata)
    spec.metadata['allowed_push_host'] = "TODO: Set to 'http://mygemserver.com'"
  else
    raise "RubyGems 2.0 or newer is required to protect against public gem pushes."
  end

  spec.files = Dir['lib/PayHubSDK/com/payhub/ws/util/*'] + Dir['bin/*']+Dir['lib/PayHubSDK/com/payhub/ws/model/*']+Dir['lib/PayHubSDK/com/payhub/ws/api/*']+Dir['lib/PayHubSDK/com/payhub/ws/extra/*']+Dir['lib/PayHubSDK/com/payhub/ws/vt/*']

  spec.files.reject! { |fn| fn.include? "CVS" }

  spec.bindir        = "exe"
  spec.executables   = spec.files.grep(%r{^exe/}) { |f| File.basename(f) }
  spec.require_paths = ["lib"]

  spec.add_development_dependency "bundler", "~> 1.10"
  spec.add_development_dependency "rake", "~> 10.0"
end
